import { Routes } from '@angular/router';

import { DashboardComponent }   from './dashboard/dashboard.component';
import { TransactionsComponent }   from './transactions/transactions.component';

export const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'transactions',
        component: TransactionsComponent
    }
]
