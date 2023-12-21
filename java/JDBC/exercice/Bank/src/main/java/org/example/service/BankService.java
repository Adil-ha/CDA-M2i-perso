package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.dao.ClientDAO;
import org.example.dao.OperationDAO;
import org.example.enumBank.TransactionType;
import org.example.models.BankAccount;
import org.example.models.Client;
import org.example.models.Operation;
import org.example.utils.DataBaseManager;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

public class BankService {
    private ClientDAO clientDAO;
    private BankAccountDAO bankAccountDAO;

    private OperationDAO operationDAO;
    private Connection connection;

    public BankService() {
        try {
            connection = DataBaseManager.getInstance().getConnection();
            clientDAO = new ClientDAO(connection);
            bankAccountDAO = new BankAccountDAO(connection);
            operationDAO = new OperationDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean addClientWithAccount(String lastName, String firstname, String phoneNumber) {
        Client client = new Client();
        client.setLastName(lastName);
        client.setFirstName(firstname);
        client.setPhoneNumber(phoneNumber);

        try {
            if (clientDAO.save(client)) {
                BankAccount bankAccount = new BankAccount(client);

                if (bankAccountDAO.save(bankAccount)) {
                    bankAccount.setClient(client);
                    return true;
                } else {
                    clientDAO.delete(client.getId());
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deposit(int accountNumber, double amountDeposit) {
        try {
            BankAccount bankAccount = bankAccountDAO.getBankAccountByAccountNumber(accountNumber);

            if (bankAccount != null) {
                double newBalance = bankAccount.getBalance() + amountDeposit;
                bankAccount.setBalance(newBalance);

                Operation operation = new Operation();
                operation.setAmount(amountDeposit);
                operation.setTransactionType(TransactionType.DEPOSIT);

                operation.setAccount(bankAccount);

                operationDAO.save(operation);

                bankAccountDAO.updateBalance(bankAccount);

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean withdraw(int accountNumber, double amountWithdrawal) {
        try {
            BankAccount bankAccount = bankAccountDAO.getBankAccountByAccountNumber(accountNumber);

            if (bankAccount != null) {
                double currentBalance = bankAccount.getBalance();

                if (currentBalance >= amountWithdrawal && amountWithdrawal >= 0) {
                    double newBalance = currentBalance - amountWithdrawal;
                    bankAccount.setBalance(newBalance);

                    Operation operation = new Operation();
                    operation.setAmount(amountWithdrawal);
                    operation.setTransactionType(TransactionType.WITHDRAWAL);
                    operation.setAccount(bankAccount);
                    operationDAO.save(operation);

                    bankAccountDAO.updateBalance(bankAccount);

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public BankAccount getAccountByNumber(int accountNumber) {
        try {
            return bankAccountDAO.getBankAccountByAccountNumber(accountNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addClientWithoutAccount(String lastName,String firstname,String phoneNumber){
        Client client = new Client();
        client.setLastName(lastName);
        client.setFirstName(firstname);
        client.setPhoneNumber(phoneNumber);

        try {
            if (clientDAO.save(client)) {
              return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addAccountForClient(int clientId) {
        try {
            Client client = clientDAO.getClientById(clientId);
            if(client != null){
                BankAccount bankAccount = new BankAccount(client);
                bankAccountDAO.save(bankAccount);
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BankAccount> viewClientAccounts(int clientId) {
        try {
            Client client = clientDAO.getClientById(clientId);
            if (client != null) {
                return bankAccountDAO.getAccountsByClient(client);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}