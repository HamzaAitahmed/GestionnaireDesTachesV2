import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'supprimerCaracterePipe',
  standalone: false
})
export class SupprimerCaracterePipePipe implements PipeTransform {

  transform(value: string, caractereSupprimer: string, caractereRemplacer: string): string {
    if (!value) return value; // Retourner la valeur originale si elle est vide
    if (!caractereSupprimer) return value; // Retourner la valeur originale si aucun caractère n'est spécifié

    // Créer une expression régulière pour supprimer tous les caractères spécifiés
    const regex = new RegExp(caractereSupprimer, 'g');
    return value.replace(regex, caractereRemplacer); // Remplacer tous les caractères spécifiés par des espaces
  }

}
