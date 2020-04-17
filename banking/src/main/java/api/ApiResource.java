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
    /**
     * REST endpoint to get customer by id
     *
     * @param id
     * @return CustomerDetails
     * @throws NotFoundException
     */
    @Path("customer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(customerManager.getCustomer(cIdentifier));
    }

    /**
     * REST endpoint to get customer accounts by id
     *
     * @param id
     * @return List of AccountDetails
     * @throws NotFoundException
     */
    @Path("customer/accounts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccounts(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(customerManager.getAccounts(cIdentifier));
    }

    //BANK
    /**
     * REST endpoint to get bank by id
     *
     * @param id
     * @return BankDetails
     * @throws NotFoundException
     */
    @Path("bank")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBank(@QueryParam("id") String id) throws NotFoundException {
        BankIdentifier bIdentifier = new BankIdentifier(id);
        return gson.toJson(bankManager.getBank(bIdentifier));
    }

    /**
     * REST endpoint to get bank accounts by id
     *
     * @param id
     * @return List of AccountDetails
     * @throws NotFoundException
     */
    @Path("bank/accounts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBankAccounts(@QueryParam("id") String id) throws NotFoundException {
        CustomerIdentifier cIdentifier = new CustomerIdentifier(id);
        return gson.toJson(bankManager.getAccounts(cIdentifier));
    }

    //ACCOUNT
    /**
     * REST endpoint to get account by id
     *
     * @param id
     * @return AccountDetails
     * @throws NotFoundException
     */
    @Path("account")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccount(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getAccount(aIdentifier));
    }

    /**
     * REST endpoint to get account balance by id
     *
     * @param id
     * @return long
     * @throws NotFoundException
     */
    @Path("account/balance")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBalance(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getBalance(aIdentifier));
    }

    /**
     * REST endpoint to get account withdrawals by id
     *
     * @param id
     * @return List of MovementDetails
     * @throws NotFoundException
     */
    @Path("account/withdrawals")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWithdrawals(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getWithdrawals(aIdentifier));
    }

    /**
     * REST endpoint to get account deposits by id
     *
     * @param id
     * @return List of MovementDetails
     * @throws NotFoundException
     */
    @Path("account/deposits")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDeposits(@QueryParam("id") String id) throws NotFoundException {
        AccountIdentifier aIdentifier = new AccountIdentifier(id);
        return gson.toJson(accountManager.getDeposits(aIdentifier));
    }

    /**
     * REST endpoint to post (transfer by id) amount from source to target
     *
     * @param amount
     * @param source
     * @param target
     * @return Response.status(200)
     * @throws NotFoundException
     */
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

    /**
     * REST endpoint to post (transfer by number) amount from sourceAccNumber to
     * targetAccNumber
     *
     * @param amount
     * @param sourceAccNumber
     * @param targetAccNumber
     * @return Response.status(200)
     * @throws NotFoundException
     */
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

    /**
     * REST endpoint to deposit amount to account with id
     *
     * @param amount
     * @param id
     * @return MovementDetails
     * @throws NotFoundException
     */
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

    /**
     * REST endpoint to withdraw amount from account with id
     *
     * @param amount
     * @param id
     * @return MovementDetails
     * @throws NotFoundException
     */
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
