package uk.co.aqubesolutions.awsspringbootrestapi.apitest.karate.healthcheck;

import com.intuit.karate.junit5.Karate;

class HealthzApiTestRunner {
    @Karate.Test
    Karate testMathsOperationFeature() {
        return Karate.run().relativeTo(getClass());
    }
}
