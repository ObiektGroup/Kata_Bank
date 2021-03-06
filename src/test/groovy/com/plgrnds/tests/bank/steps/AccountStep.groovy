package com.plgrnds.tests.bank.steps


import com.plgrnds.tests.bank.Account
import com.plgrnds.tests.bank.AccountRepository
import com.plgrnds.tests.bank.Bank
import com.plgrnds.tests.bank.Customer
import com.plgrnds.tests.bank.InMemoryAccountRepository
import groovy.transform.Field

import static org.assertj.core.api.Assertions.assertThat


this.metaClass.mixin(cucumber.api.groovy.EN)

@Field AccountRepository accountRepository
@Field Customer customer
@Field Bank bank

@Field newAccount


Given(~/^there is a bank$/) { ->
    accountRepository = new InMemoryAccountRepository()
    bank = new Bank(accountRepository)
}

Given(~/^a customer wants to open an account$/) { ->
    customer = new Customer()
}

When(~/^his account is created$/) { ->
    newAccount = new Account(customer)
}

Then(~/^there is a new account on his account list$/) { ->
    accountRepository.addAccount(newAccount)
}

And(~/^the balance on this account is 0$/) { ->
    newAccount.balance = 0
}