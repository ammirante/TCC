import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private readonly OPEN_BANKING = '/open-banking';

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.data['breadcrumb']);
  }

  redirecionarParaOpenBanking(): void {
    this.router.navigate([this.OPEN_BANKING]);
  }

}
