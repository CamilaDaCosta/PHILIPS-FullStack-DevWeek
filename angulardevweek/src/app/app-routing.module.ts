import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

/**
 * Configurando rotas da url
 */
const routes: Routes = [
  /**
   * Se o path for padrão, no caso, path:'' ele vai redirecionar para o modulo /ocorrencias
   * pathMatch é para confirmar se o path está correto
   */
  {
    path:'', pathMatch:'full', redirectTo:'ocorrencias'
  },
  {
    path: 'ocorrencias',
    loadChildren: () => import('./ocorrencias/ocorrencias.module').then(m => m.OcorrenciasModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
