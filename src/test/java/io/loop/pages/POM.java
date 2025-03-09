package io.loop.pages;

public class POM {
   private LoginPage loginPage;
   private GoogleSearchPage googleSearchPage;
   private ProductPage productPage;
   private MyUploadsPage myUploadsPage;
   private InvitationsPage invitationsPage;
   private TermsAndConditionsPage termsAndConditionsPage;

    public LoginPage getLoginPage() {
        if(loginPage==null){
           loginPage = new LoginPage();
        }
        return loginPage;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        if(googleSearchPage == null){
            googleSearchPage=new GoogleSearchPage();
        }
        return googleSearchPage;
    }

    public ProductPage getProductPage() {
        if(productPage==null){
            productPage=new ProductPage();
        }
        return productPage;
    }

    public MyUploadsPage getMyUploadsPage() {
        if (myUploadsPage == null) {
            myUploadsPage = new MyUploadsPage();
        }
        return myUploadsPage;
    }

    public InvitationsPage getInvitationsPage() {
        if (invitationsPage == null) {
            invitationsPage = new InvitationsPage();
        }
        return invitationsPage;
    }

    public TermsAndConditionsPage getTermsAndConditionsPage (){
        if (termsAndConditionsPage == null) {
            termsAndConditionsPage = new TermsAndConditionsPage();
        }
        return termsAndConditionsPage;
    }
}
