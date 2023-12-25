export interface Login{
    email:string;
    motDePasse:string
}

export interface User{
    nom:string;
    prenom:string;
    email:string;
    role:string;
    ecole:string;
}


export interface Response {
    page: Page;
    _embedded: {
      adherents: User[];
      books:Books[]
    };
  }


  export interface Page {
    size: number;
    totalElements: number;
    totalPages: number;
    number: number;
  }

  export interface Books{
    reference:string;
    libelle:string;
    auteur:string;
    langue:string;
    etat:string;
    nbrExemplaire:number;
    categorie:string;
    genre:string;
    description:string
  }