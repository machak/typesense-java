package org.typesense.interceptor;

import java.io.IOException;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetryInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(RetryInterceptor.class);

    final int retryLimit;
    public RetryInterceptor() {
        retryLimit = 3;
    }

    public RetryInterceptor(final int retryLimit) {
        this.retryLimit = retryLimit;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        Response response = getResponse(chain, request);
        int tryCount = 0;
        while (!response.isSuccessful() && tryCount < retryLimit) {
            log.debug("Request failed - {}", tryCount);
            tryCount++;
            response = getResponse(chain, request);
        }
        return response;
    }

    @NotNull
    private static Response getResponse(final Chain chain, final Request request) throws IOException {
        try {
            return chain.proceed(request);
        } catch (IOException e) {
            log.warn("Error processing request", e);
            throw new IOException(e);
        }
    }

}
