package org.typesense.api;

import java.util.HashMap;
import java.util.Map;

public class OkHttpTypesenseClient implements TypesenseClient {
    private final Configuration configuration;

    private final TypesenseCall apiCall;

    private final Collections collections;
    private final Map<String, Collection> individualCollections;

    private final Aliases aliases;
    private final Map<String, Alias> individualAliases;

    private final Keys keys;
    private final Map<Long, Key> individualKeys;

    private final Health health;
    private final Operations operations;
    private final Metrics metrics;
    private final Debug debug;
    private final MultiSearch multiSearch;

    public OkHttpTypesenseClient(final Configuration configuration) {
        this.configuration = configuration;
        this.apiCall = new OkHttpCall(configuration);
        collections = new Collections(apiCall);
        this.individualCollections = new HashMap<>();
        this.aliases = new Aliases(this.apiCall);
        this.individualAliases = new HashMap<>();
        this.keys = new Keys(this.apiCall);
        this.individualKeys = new HashMap<>();
        this.health = new Health(this.apiCall);
        this.operations = new Operations(this.apiCall);
        this.metrics = new Metrics(this.apiCall);
        this.debug = new Debug(this.apiCall);
        this.multiSearch = new MultiSearch(this.apiCall);
    }


    @Override
    public Collection collections(final String name) {
        if (!this.individualCollections.containsKey(name)) {
            individualCollections.put(name, new Collection(name, this.apiCall, this.configuration));
        }
        return individualCollections.get(name);
    }

    @Override
    public Collections collections() {
        return this.collections;
    }

    @Override
    public Aliases aliases() {
        return this.aliases;
    }

    @Override
    public Alias aliases(final String name) {

        if (!this.individualAliases.containsKey(name)) {
            this.individualAliases.put(name, new Alias(this.apiCall, name));
        }
        return this.individualAliases.get(name);
    }

    @Override
    public Keys keys() {
        return keys;
    }

    @Override
    public Key keys(final Long id) {
        if (!this.individualKeys.containsKey(id)) {
            this.individualKeys.put(id, new Key(id, this.apiCall));
        }
        return this.individualKeys.get(id);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public TypesenseCall getApiCall() {
        return apiCall;
    }

    @Override
    public Collections getCollections() {
        return collections;
    }

    @Override
    public Map<String, Collection> getIndividualCollections() {
        return individualCollections;
    }

    @Override
    public Aliases getAliases() {
        return aliases;
    }

    @Override
    public Map<String, Alias> getIndividualAliases() {
        return individualAliases;
    }

    @Override
    public Keys getKeys() {
        return keys;
    }

    @Override
    public Map<Long, Key> getIndividualKeys() {
        return individualKeys;
    }

    @Override
    public Health getHealth() {
        return health;
    }

    @Override
    public Operations getOperations() {
        return operations;
    }

    @Override
    public Metrics getMetrics() {
        return metrics;
    }

    @Override
    public Debug getDebug() {
        return debug;
    }

    @Override
    public MultiSearch getMultiSearch() {
        return multiSearch;
    }
}
