package org.typesense.api;

import java.util.HashMap;
import java.util.Map;

public class JerseyClient implements Client {
    private final Configuration configuration;

    private final ApiCall apiCall;

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

    public JerseyClient(final Configuration configuration) {
        this.configuration = configuration;
        this.apiCall = new ApiCall(configuration);
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
    public Collection collections(String name) {
        Collection retVal;

        if (!this.individualCollections.containsKey(name)) {
            individualCollections.put(name, new Collection(name, this.apiCall, this.configuration));
        }

        retVal = individualCollections.get(name);

        return retVal;
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
    public Alias aliases(String name) {
        Alias retVal;

        if (!this.individualAliases.containsKey(name)) {
            this.individualAliases.put(name, new Alias(this.apiCall, name));
        }

        retVal = this.individualAliases.get(name);

        return retVal;
    }

    @Override
    public Keys keys() {
        return this.keys;
    }

    @Override
    public Key keys(Long id) {
        Key retVal;

        if (!this.individualKeys.containsKey(id)) {
            this.individualKeys.put(id, new Key(id, this.apiCall));
        }

        retVal = this.individualKeys.get(id);
        return retVal;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public ApiCall getApiCall() {
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
