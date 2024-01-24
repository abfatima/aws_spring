package com.sip.ams.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.CompteBancaire;

@Controller
@RequestMapping("/compte")
public class CompteBancaireController {

	static List<CompteBancaire> cbs = new ArrayList<>();
	static int nbc = 0;

	// bloc static s'exécute lors de l'invocation de la classe BanqueController
	static {

		nbc++;
		CompteBancaire cb1 = new CompteBancaire(nbc, "Fatima", 900000, LocalDate.of(2023, 10, 12), 100, "0609223422",
				"fatima@gmail.com", 2000.0);
		nbc++;
		CompteBancaire cb2 = new CompteBancaire(nbc, "aksel", 10000, LocalDate.of(2021, 12, 11), 100, "0609223822",
				"fa@gmail.com", 9000.0);
		
		nbc++;
		CompteBancaire cb3 = new CompteBancaire(nbc, "Anne", 20000, LocalDate.of(2000, 12, 11), 200, "0609223822",
				"fa@gmail.com", 9000.0);

		cbs.add(cb1);
		cbs.add(cb2);
		cbs.add(cb3);

	}

	@RequestMapping("/list")
	public String listeComptes(Model model) {
		model.addAttribute("cbs", cbs);
		return "compte/listComptes";
	}

	@GetMapping("/add")
	public String formCompte() {
		return "compte/addCompte";
	}

	@PostMapping("/add")
	public String saveCompte(
			@RequestParam("proprietaire") String proprietaire, 
			@RequestParam("solde") double solde,
			@RequestParam("dateCreation") LocalDate dateCreation, 
			@RequestParam("numBanque") int numBanque,
			@RequestParam("telephone") String telephone, 
			@RequestParam("email") String email,
			@RequestParam("salaire") Double salaire) {
		nbc++;
		CompteBancaire cb = new CompteBancaire(nbc, proprietaire, solde, dateCreation, numBanque, telephone, email,
				salaire);
		cbs.add(cb);
		return "redirect:/compte/list";
	}

	@GetMapping("/detailsCompte")
	// @ResponseBody()
	public String detailsCompte(@RequestParam("numCompte") int numCompte, Model model) {
		CompteBancaire targetCompte = null;

		for (CompteBancaire comptebancaire : cbs) {
			if (comptebancaire.getNumCompte() == numCompte) {
				targetCompte = comptebancaire;

			}
			model.addAttribute("cb", targetCompte);
			System.out.println(" targetcompte" + targetCompte);
		}

		return "compte/detailsCompte";
	}

	 @GetMapping("/editCompte/{numCompte}")
	    public String editCompteForm(@PathVariable int numCompte, Model model) {
	        CompteBancaire targetCompte = findCompteByNumCompte(numCompte);
	        model.addAttribute("cb", targetCompte);
	        return "compte/editCompte";
	    }

	    @PostMapping("/editCompte/{numCompte}")
	    public String updateCompte(
	            @PathVariable int numCompte,
	            @RequestParam("proprietaire") String proprietaire,
	            @RequestParam("solde") double solde,
	            @RequestParam("dateCreation") LocalDate dateCreation,
	            @RequestParam("numBanque") int numBanque,
	            @RequestParam("telephone") String telephone,
	            @RequestParam("email") String email,
	            @RequestParam("salaire") Double salaire) {
	        CompteBancaire targetCompte = findCompteByNumCompte(numCompte);

	        // Vérifiez si le compte existe
	        if (targetCompte != null) {
	            targetCompte.setProprietaire(proprietaire);
	            targetCompte.setSolde(solde);
	            targetCompte.setDateCreation(dateCreation);
	            targetCompte.setIdBanque(numBanque);
	            targetCompte.setTelephone(telephone);
	            targetCompte.setEmail(email);
	            targetCompte.setSalaire(salaire);
	        }

	        return "redirect:/compte/list";
	    }
	    
	    @GetMapping("/deleteCompte")
	    public String deleteCompte(@RequestParam("numCompte") int numCompte) {
	        // Recherche du compte à supprimer
	        CompteBancaire compteToDelete = findCompteByNumCompte(numCompte);

	        // Vérifiez si le compte existe
	        if (compteToDelete != null) {
	            // Supprimez le compte de la liste
	            cbs.remove(compteToDelete);
	        }

	        return "redirect:/compte/list";
	    }

	    

	    // Méthode utilitaire pour trouver un compte par son numéro de compte
	    private CompteBancaire findCompteByNumCompte(int numCompte) {
	        return cbs.stream()
	                .filter(compte -> compte.getNumCompte() == numCompte)
	                .findFirst()
	                .orElse(null);
	    }
	}