module academy.learnprogramming.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive academy.learnprogramming.common;    //transitive !!!

    exports academy.learnprogramming.db;
}