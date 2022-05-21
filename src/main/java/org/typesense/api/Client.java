package org.typesense.api;

import java.util.Map;

public interface Client {

    Collection collections(String name);

    Collections collections();

    Aliases aliases();

    Alias aliases(String name);

    Keys keys();

    Key keys(Long id);

    Configuration getConfiguration();

    ApiCall getApiCall();

    Collections getCollections();

    Map<String, Collection> getIndividualCollections();

    Aliases getAliases();

    Map<String, Alias> getIndividualAliases();

    Keys getKeys();

    Map<Long, Key> getIndividualKeys();

    Health getHealth();

    Operations getOperations();

    Metrics getMetrics();

    Debug getDebug();

    MultiSearch getMultiSearch();
}
