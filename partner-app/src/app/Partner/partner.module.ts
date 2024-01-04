import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PartnerComponent } from './partner.component';
@NgModule({
  declarations: [
    PartnerComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PartnerComponent
  ]
})
export class PartnerModule { }
