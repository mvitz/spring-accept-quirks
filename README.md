# Spring Accept Quirks

When encountering an exception Spring uses the `BasicErrorController` for
rendering a matching view for the exception. Unfortunately there is at least one
case where this does not work.

If sending a request with `Accept: */*` Spring correctly detects the only
available endpoint (which states that it will render `text/html`). If an
exception is thrown here Spring finally forwards the request to the
`BasicErrorController`. Because of `*/*` this will **NOT** call the
`errorHtml`-method but `error` instead. This results in a `ResponseEntity` which
Spring does not know how to render as HTML.

## Steps to produce

 1. Start application: `./mvnw spring-boot:run`
 2. Call endpoint with `Accept: text/html`-header with curl: `curl -v -H
    Accept:text/html http://localhost:8080`. This results correctly in a `500`.
 3. Call endpoint without `Accept`-header with curl: `curl -v
    http://localhost:8080`. The server will respond with `406`.

## License

spring-accept-quirks is Open Source software released under the
[Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).
