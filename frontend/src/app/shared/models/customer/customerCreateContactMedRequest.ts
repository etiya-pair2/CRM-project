export interface customerCreateContactMedRequest{
    customerId: string | null;
    email:string,
    homePhone?:string,
    mobilePhone:string,
    fax?:string,
    
}