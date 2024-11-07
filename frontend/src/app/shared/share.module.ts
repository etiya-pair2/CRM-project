import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedRoutingModule } from './shared-routing.module';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { UUIDShortenerPipe } from './pipes/uuidShortener.pipe';

@NgModule({
  declarations: [ ], // Bu modülün altındaki (bu modülün sahip oldugu) schematicler (NavbarComponent)
  imports: [CommonModule, SharedRoutingModule, UUIDShortenerPipe], // Bu modülün dışarıdan aldığı modül ya da standalone componentlar.
  exports: [], // Bu modül import edildiğinde dışarıdan hangi schematiclerine erişim açılacak?
})
export class SharedModule {}