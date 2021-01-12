package com.phtowey.flowable.modeler.config;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseConnection;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.flowable.ui.common.service.exception.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DatabaseConfiguration
 *
 * @author photowey
 * @date 2021/01/13
 * @since 1.0.0
 */
@Configuration
public class FlowableModelerDatabaseConfiguration {

    private static final Logger log = LoggerFactory.getLogger(FlowableModelerDatabaseConfiguration.class);

    protected static final String LIQUIBASE_CHANGELOG_PREFIX = "ACT_DE_";

    @Bean
    public Liquibase liquibase(DataSource dataSource) {
        log.info("--- start Configuring liquibase ---");
        Liquibase liquibase = null;
        try {
            DatabaseConnection connection = new JdbcConnection(dataSource.getConnection());
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(connection);
            database.setDatabaseChangeLogTableName(LIQUIBASE_CHANGELOG_PREFIX + database.getDatabaseChangeLogTableName());
            database.setDatabaseChangeLogLockTableName(LIQUIBASE_CHANGELOG_PREFIX + database.getDatabaseChangeLogLockTableName());
            liquibase = new Liquibase("META-INF/liquibase/flowable-modeler-app-db-changelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update("flowable");
            return liquibase;
        } catch (Exception e) {
            throw new InternalServerErrorException("Error creating liquibase database", e);
        } finally {
            this.closeDatabase(liquibase);
        }
    }

    private void closeDatabase(Liquibase liquibase) {
        if (liquibase != null) {
            Database database = liquibase.getDatabase();
            if (database != null) {
                try {
                    database.close();
                } catch (DatabaseException e) {
                    log.warn("--- error closing database ---", e);
                }
            }
        }
    }
}
