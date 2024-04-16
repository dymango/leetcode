//package app.stripe;
//
//import com.google.gson.Gson;
//import com.google.gson.annotations.SerializedName;
//import com.stripe.Stripe;
//import com.stripe.model.PaymentIntent;
//import com.stripe.param.PaymentIntentCreateParams;
//
//import java.nio.file.Paths;
//
//import static spark.Spark.port;
//import static spark.Spark.post;
//import static spark.Spark.staticFiles;
//
//public class Server {
//    private static Gson gson = new Gson();
//
//    static class CreatePaymentItem {
//        @SerializedName("id")
//        String id;
//
//        public String getId() {
//            return id;
//        }
//    }
//
//    static class CreatePayment {
//        @SerializedName("items")
//        CreatePaymentItem[] items;
//
//        public CreatePaymentItem[] getItems() {
//            return items;
//        }
//    }
//
//    static class CreatePaymentResponse {
//        private String clientSecret;
//
//        public CreatePaymentResponse(String clientSecret) {
//            this.clientSecret = clientSecret;
//        }
//    }
//
//    static int calculateOrderAmount(Object[] items) {
//        // Replace this constant with a calculation of the order's amount
//        // Calculate the order total on the server to prevent
//        // people from directly manipulating the amount on the client
//        return 1400;
//    }
//
//
//    public static void main(String[] args) {
//        port(4242);
//        staticFiles.externalLocation(Paths.get("public").toAbsolutePath().toString());
//
//        // This is a public sample test API key.
//        // Don’t submit any personally identifiable information in requests made with this key.
//        // Sign in to see your own test API key embedded in code samples.
//        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
//
//        post("/create-payment-intent", (request, response) -> {
//            response.type("application/json");
//            CreatePayment postBody = gson.fromJson(request.body(), CreatePayment.class);
//
//            PaymentIntentCreateParams params =
//                PaymentIntentCreateParams.builder()
//                    .setAmount(new Long(calculateOrderAmount(postBody.getItems())))
//                    .setCurrency("usd")
//                    // In the latest version of the API, specifying the `automatic_payment_methods` parameter is optional because Stripe enables its functionality by default.
//                    .setAutomaticPaymentMethods(
//                        PaymentIntentCreateParams.AutomaticPaymentMethods
//                            .builder()
//                            .setEnabled(true)
//                            .build()
//                    )
//                    .build();
//
//            // Create a PaymentIntent with the order amount and currency
//            PaymentIntent paymentIntent = PaymentIntent.create(params);
//
//            CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
//            return gson.toJson(paymentResponse);
//        });
//    }
//}
//
