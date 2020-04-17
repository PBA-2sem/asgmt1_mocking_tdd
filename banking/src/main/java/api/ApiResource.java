package api;

import DTOs.identifiers.AccountIdentifier;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import DataLayer.Utils;
import com.google.gson.Gson;
import exceptions.NotFoundException;
import implementations.db.AccountManager;
import implementations.db.BankManager;
import implementations.db.CustomerManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
@Path("")
public class ApiResource {

    CustomerManager customerManager = new CustomerManager();
    BankManager bankManager = new BankManager();
    AccountManager accountManager = new AccountManager();
    Gson gson = new Gson();

    @Context
    private UriInfo context;

    public ApiResource() {
        Utils.establishDBConnection();
    }

    //CUSTOMER
    @Path("customer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(customerManager.getCustomer(cIdentifier));
    }

    @Path("customer/accounts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccounts(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(customerManager.getAccounts(cIdentifier));
    }

    //BANK
    @Path("bank")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBank(@QueryParam("id") String id) throws NotFoundException {
        BankIdentifier bIdentifier = new BankIdentifier(id);
        return gson.toJson(bankManager.getBank(bIdentifier));
    }

    @Path("bank/accounts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBankAccounts(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(bankManager.getAccounts(cIdentifier));
    }

    //ACCOUNT
    @Path("account")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccount(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getAccount(aIdentifier));
    }

    @Path("account/balance")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBalance(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getBalance(aIdentifier));
    }

    @Path("account/withdrawals")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithdrawals(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getWithdrawals(aIdentifier));
    }

    @Path("account/deposits")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDeposits(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getDeposits(aIdentifier));
    }

    @Path("account/transfer/id")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferByAccountIdentifier(
            @QueryParam("amount") String amount,
            @QueryParam("source") String source,
            @QueryParam("target") String target
    ) throws NotFoundException {
        long transferamount = Long.parseLong(amount);
        AccountIdentifier aSource = new AccountIdentifier(source);
        AccountIdentifier aTarget = new AccountIdentifier(target);

        accountManager.transfer(transferamount, aSource, aTarget);
        return Response.status(200)
                .entity("amount: " + transferamount + "source: " + source + "target: " + target)
                .build();
    }

    @Path("account/transfer/number")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferByAccountNumber(
            @QueryParam("amount") String amount,
            @QueryParam("source") String sourceAccNumber,
            @QueryParam("target") String targetAccNumber
    ) throws NotFoundException {
        long transferamount = Long.parseLong(amount);
        AccountIdentifier aSource = new AccountIdentifier(sourceAccNumber);
        AccountIdentifier aTarget = new AccountIdentifier(targetAccNumber);

        accountManager.transfer(transferamount, aSource, aTarget);
        return Response.status(200)
                .entity("amount: " + transferamount + "source: " + sourceAccNumber + "target: " + targetAccNumber)
                .build();
    }

    @Path("account/deposit")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deposit(
            @QueryParam("amount") String amount,
            @QueryParam("id") String id
    ) throws NotFoundException {
        long transferamount = Long.parseLong(amount);
        AccountIdentifier aIdentifier = new AccountIdentifier(id);

        accountManager.deposit(transferamount, aIdentifier);
        return Response.status(200)
                .entity("amount: " + transferamount + "id: " + aIdentifier.getId())
                .build();
    }

    @Path("account/withdraw")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response withdraw(
            @QueryParam("amount") String amount,
            @QueryParam("id") String id
    ) throws NotFoundException {
        long transferamount = Long.parseLong(amount);
        AccountIdentifier aIdentifier = new AccountIdentifier(id);

        accountManager.withdraw(transferamount, aIdentifier);
        return Response.status(200)
                .entity("amount: " + transferamount + "id: " + aIdentifier.getId())
                .build();
    }
}
