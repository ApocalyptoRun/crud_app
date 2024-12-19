import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'http://localhost:8081';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  addCustomer(customer: any): Observable<any> {
    return this.http.post(BASIC_URL + '/api/addCustomer', customer);
  }

  updateCustomer(id: number, customer: any): Observable<any> {
    return this.http.put(BASIC_URL + '/api/updateCustomer/' + id , customer);
  }

  findAllCustomers(): Observable<any> {
    return this.http.get(BASIC_URL + '/api/allCustomers');
  }

  findCustomer(id: number): Observable<any> {
    return this.http.get(BASIC_URL + '/api/findCustomer/' + id);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(BASIC_URL + '/api/deleteCustomer/' + id);
  }

}
