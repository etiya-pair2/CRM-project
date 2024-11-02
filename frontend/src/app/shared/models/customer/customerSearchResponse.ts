//import{ v4asuuidv4 }from 'uuid';

export interface CustomerSearchResponse {
    customerId: string;
    accNumber: string;
    mobilePhone:string
    firstName: string;
    lastName : string;
    nationalityId: string;
    contactMediumList: ContactMedium[];
    billingAccountList: BillingAccount[];
}
export interface ContactMedium {
    mobilePhone: string;
    
}

export interface BillingAccount {
    accountNumber: string;   
}