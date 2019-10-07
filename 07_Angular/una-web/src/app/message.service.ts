import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: string[] = []; //new Array()

  add(message: string) {
    this.messages.push(message);
  }

  clear() :void {
    this.messages = [];
  }

}
