package com.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import groovy.transform.CompileStatic
import org.apache.log4j.Logger

import groovy.json.JsonOutput
import groovy.transform.builder.Builder

@CompileStatic
class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

  private static final Logger LOG = Logger.getLogger(Handler.class)

  @Override
  ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
    LOG.info("received: " + input)

    def aMsg = input.queryStringParameters ? input.queryStringParameters["alt"] : "no alt";

    Response responseBody = Response.builder()
        .message('Using Serverless v1.x! The GROOVY function executed with success!')
        .altMess(aMsg)
        .input(input)
        .build()
        
    return ApiGatewayResponse.builder()
        .statusCode(200)
        .body(responseBody.toJson())
        .headers(['X-Powered-By': 'AWS Lambda & serverless'])
        .build()
  }
}

@Builder
@CompileStatic
class Response {
  Object message  // structure for the JSON output
  Object altMess
  Map<String, Object> input

  String toJson() {
    return JsonOutput.prettyPrint(JsonOutput.toJson(this))
  }
}

@Builder
@CompileStatic
class ApiGatewayResponse {
  int statusCode
  String body
  Map<String, String> headers
}
