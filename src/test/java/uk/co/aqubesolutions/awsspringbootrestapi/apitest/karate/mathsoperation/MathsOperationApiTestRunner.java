package uk.co.aqubesolutions.awsspringbootrestapi.apitest.karate.mathsoperation;

import com.intuit.karate.junit5.Karate;

class MathsOperationApiTestRunner {
    @Karate.Test
    Karate testMathsOperationFeature() {
        return Karate.run().relativeTo(getClass());
    }
}
