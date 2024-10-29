export interface customerCreateInfoRequest {
    nationalityId: string,
    firstName: string,
    middleName?: string,
    lastName: string,
    gender: string,
    birthday: string,
    motherName?: string,
    fatherName?: string
}