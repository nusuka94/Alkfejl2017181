import {
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatTableModule,
  MatToolbarModule,
  MatListModule
} from '@angular/material';
import {NgModule} from '@angular/core';

@NgModule({
  imports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatToolbarModule, MatTableModule, MatSelectModule, MatListModule],
  exports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatToolbarModule, MatTableModule, MatSelectModule, MatListModule],
})
export class MaterialItemsModule {
}
