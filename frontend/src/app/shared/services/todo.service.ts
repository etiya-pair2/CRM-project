import { Injectable } from '@angular/core';
import { GetToDoListResponse } from '../models/getToDoListResponse';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

//@Injectable Angular bu class'ı dep. olarak görsün
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  controllerUrl = `${environment.BASE_API_URL}`
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<GetToDoListResponse[]> {
    return this.httpClient.get<GetToDoListResponse[]>(
      this.controllerUrl
    )
  }

  getById(id: number): Observable<GetToDoListResponse[]> {
    return this.httpClient.get<GetToDoListResponse[]>(
      `${this.controllerUrl}/${id}`
    )
  }
}
