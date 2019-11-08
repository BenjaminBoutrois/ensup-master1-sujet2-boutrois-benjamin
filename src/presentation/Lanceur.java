package presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import metier.*;
import service.*;

public class Lanceur
{

	public static void main(String[] args)
	{
		ServiceImpl service = new ServiceImpl();
		
		// Création personne 1 et 2 et annonces 1, 2, 3 et 4
		Personne personne1 = new Personne(0, "Boutrois", "Benjamin", "bb", "bb1", new Date(), new ArrayList<Annonce>());
		Personne personne2 = new Personne(1, "Morganti", "Jonathan", "jm", "jm1", new Date(), new ArrayList<Annonce>());
		
		Annonce annonce1 = new Annonce(0, "annonce 1", "detail", 5.2, personne1);
		Annonce annonce2 = new Annonce(1, "annonce 2", "des tailles", 10.7, personne1);
		
		Annonce annonce3 = new Annonce(2, "annonce 3", "detail", 8.2, personne2);
		Annonce annonce4 = new Annonce(3, "annonce 4", "des tailles", 14.7, personne2);
		
		List<Annonce> annoncesPersonne1 = new ArrayList<Annonce>();
		annoncesPersonne1.add(annonce1);
		annoncesPersonne1.add(annonce2);

		personne1.setAnnonces(annoncesPersonne1);
		
		List<Annonce> annoncesPersonne2 = new ArrayList<Annonce>();
		annoncesPersonne2.add(annonce3);
		annoncesPersonne2.add(annonce4);
		
		personne2.setAnnonces(annoncesPersonne2);
		
		service.creerPersonne(service.base, personne1);
		service.creerPersonne(service.base, personne2);
		System.out.println("Liste après 2 x service.creerPersonne :");
		
		for(Personne personne : service.base)
			System.out.println(personne);
		
		System.out.println("\ngetPersonne (id 0) :\n" + service.getPersonne(service.base, 0));
		
		service.deletePersonne(service.base, 0);
		
		System.out.println("\nliste après service.deletePersonne (id 0) :");
		
		for(Personne personne : service.base)
			System.out.println(personne);
		
		service.updatePersonne(service.base, personne2, "Boutrois", "Benjamin", new Date());
		
		System.out.println("\nliste après service.updatePersonne :");
		
		for(Personne personne : service.base)
			System.out.println(personne);
		
		System.out.println("\nNettoyage de la liste... Ajout de deux personnes.");
		service.deletePersonne(service.base, 1);
		personne2 = new Personne(1, "Morganti", "Jonathan", "jm", "jm1", new Date(), annoncesPersonne2);
		service.creerPersonne(service.base, personne1);
		service.creerPersonne(service.base, personne2);
		
		System.out.println("\nservice.findAllPersonnes :\n" + service.findAllPersonnes());
		
		System.out.println("\nservice.getPersonneId : \n" + service.getPersonneId(service.base, personne1));
		
		System.out.println("\nservice.affichePersonnes : \n");
		service.affichePersonnes();
		
		System.out.println("\nservice.affichePersonnes (personne 1) : \n");
		service.afficheAnnoncesPersonne(personne1);
		
		Annonce annonce5 = new Annonce(4, "annonce 5", "detail", 18.2, new Personne());
		Annonce annonce6 = new Annonce(5, "annonce 6", "detail", 20.8, new Personne());
		
		System.out.println("\nservice.creerAnnonce (personne 1, annonce 5 et personne 2, annonce 6) :");
		service.creerAnnonce(personne1, annonce5);
		service.creerAnnonce(personne2, annonce6);
		
		System.out.println("Personne 1 :");
		service.afficheAnnoncesPersonne(personne1);
		System.out.println("Personne 2 :");
		service.afficheAnnoncesPersonne(personne2);
		
		System.out.println("\nservice.getAnnonce (personne 1, id annonce : 4) :\n" + service.getAnnonce(personne1, 5));
		
		service.deleteAnnonce(personne1, 4);
		System.out.println("\nservice.deleteAnnonce (personne 1, id annonce : 4) :\n");
		service.afficheAnnoncesPersonne(personne1);
		
		System.out.println("\nservice.updateAnnonce (personne 1, annonce 1) :");
		service.updateAnnonce(personne1, annonce1, "test", "test detail");
		
		service.afficheAnnoncesPersonne(personne1);

		System.out.println("\nservice.findAllAnnonces (personne1) :\n" + service.findAllAnnonce(personne1));
	}

}
