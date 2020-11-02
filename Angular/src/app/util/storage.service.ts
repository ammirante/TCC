import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class StorageService {
    private storageSub = new Subject<string>();

    watchStorage(): Observable<any> {
        return this.storageSub.asObservable();
    }

    setItem(key: string, data: any): void {
        localStorage.setItem(key, data);
        this.storageSub.next('changed');
    }

    removeItem(key): void {
        localStorage.removeItem(key);
        this.storageSub.next('changed');
    }
}
