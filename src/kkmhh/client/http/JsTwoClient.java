package kkmhh.client.http;

public class JsTwoClient {
    private void trythat(){
        JsonPlaceHolderClient jsonPlaceHolderClient = new JsonPlaceHolderClient();
        jsonPlaceHolderClient.getStatus();
    }

    public static void main(String[] args) {
        JsTwoClient jsTwoClient = new JsTwoClient();
        jsTwoClient.trythat();
    }
}
