export interface customerGetAddressByCustomerIdResponse{
    id: string;
    customerId: string; // string
    districtName: string; // string
    postalCode: string; // string
    description: string; // string
    flatNumber?: string; // string
    cityName: string; 
    }