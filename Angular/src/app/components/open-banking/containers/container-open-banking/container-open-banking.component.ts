import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-container-open-banking',
  templateUrl: './container-open-banking.component.html',
  styleUrls: ['./container-open-banking.component.scss']
})
export class ContainerOpenBankingComponent implements OnInit {

  @ViewChild('videoPlayer')
  videoplayer: any;

  constructor(
  ) { }

  ngOnInit(): void {
  }


  video(): void {
    this.videoplayer?.Play();
  }
}
