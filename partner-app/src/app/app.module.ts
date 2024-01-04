import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { PartnerModule } from './Partner/partner.module';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    PartnerModule
  ],
  providers: []
})
export class AppModule {
  ngDoBootstrap() {}
}
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
