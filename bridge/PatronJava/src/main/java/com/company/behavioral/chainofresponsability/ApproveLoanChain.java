package com.company.behavioral.chainofresponsability;

public interface ApproveLoanChain {
    void setNext(ApproveLoanChain loan);
    ApproveLoanChain getNext();
    void crediCardRequest(int totalLoan);
}
