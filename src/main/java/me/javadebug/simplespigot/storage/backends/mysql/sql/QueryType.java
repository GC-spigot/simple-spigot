package me.javadebug.simplespigot.storage.backends.mysql.sql;

public enum QueryType {

        CREATE_TABLE("CREATE TABLE IF NOT EXISTS "),
        INSERT("INSERT INTO "),
        DELETE("DELETE FROM "),
        SELECT("SELECT ");

        private final String start;

        QueryType(String start) {
            this.start = start;
        }

        public String query(String restOfQuery) {
            return start.concat(restOfQuery);
        }
    }