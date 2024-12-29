import {Component, OnInit} from '@angular/core';
import {EquipeService} from '../services/equipe.service';
import {Equipe} from '../model/equipe.model';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-equipe',
  standalone: false,
  templateUrl: './equipe.component.html',
  styleUrl: './equipe.component.css'
})
export class EquipeComponent implements OnInit{

  public equipesNotFiltred: any;
  public equipes: Array<Equipe> = [];
  // public equipes: any;
  public keyWord: string=""
  constructor(private http:HttpClient, private equipeService: EquipeService) {}
  //
  ngOnInit(): void {
    this.getEquipe();
  //
  }
  //
  getEquipe(){
    this.equipeService.getEquipes().subscribe({
      next : data => {

        // this.equipesNotFiltred = data;   data est deja filtrer parce que j'utilise RestController au lieu de RepositoryRestRessource
        // this.equipes = this.equipesNotFiltred._embedded.equipes; // remove embbed and to initialize list of products directly

        this.equipes = data;
        console.log("############## equipes : ##################")
        console.log(this.equipes)
        for(let equipe of this.equipes)
        {
          console.log("equipe : ")
          console.log(equipe)
        }
      },
      error : (err)=>{}
    });
  }
  //
  // deleteEquipe(equipe:Equipe) {
  //   this.equipeService.supprimerEquipe(equipe).subscribe({
  //     next : data => {
  //       let index = this.equipes.indexOf(<Equipe>data)
  //       this.equipes.splice(index,1) ;
  //     },
  //     error : (err)=>{ }
  //   });
  // }
  //
  // searchEquipes() {
  //   let result= [];
  //   if(this.keyWord=="")
  //   {
  //     this.getEquipe();
  //   }
  //   for(let p of this.equipes)
  //   {
  //     if(p.nom.includes(this.keyWord)){
  //       result.push(p);
  //     }
  //   }
  //   this.equipes = result;
  // }
}
