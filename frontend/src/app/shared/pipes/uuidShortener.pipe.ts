import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uuidShortener',
  standalone: true,
})
export class UUIDShortenerPipe implements PipeTransform {
  
    transform(uuid: string, start: number = 4, end: number = 4): string {
        if (!uuid || uuid.length <= start + end) {
          return uuid;
        }
        return `${uuid.slice(0, start)}...${uuid.slice(-end)}`;
      }
}
