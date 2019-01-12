package ummto.l3.travelagency.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ummto.l3.travelagency.accessdonnees.HotelDao;
import ummto.l3.travelagency.bdd.Hotel;

/**
 * 
 * @author djebarri
 *         <p>
 *         Cette classe permet de renvoyer des réponse sous forme de json, aprés
 *         avoir interroger la bdd pour récupérer les éléments nécessaire
 *         </p>
 * 
 *         <p>
 *         l'annotation {@link RestController} permet de rendre accessible cette
 *         classe par appels http (exemple le fait d'accéder à un site web un
 *         appel http avec la méthode get est faite) <br/>
 *         l'annotation {@link RequestMapping} permet de lier spécifier une url
 *         par laquelle cette classe pour étre appelé par internet
 *         </p>
 * 
 *         <p>
 *         le format de retour est le json (javascript objet notation afin
 *         d'étre utiliser pour l'affichage des résultat dans la partie front
 *         (ihm)
 *         </p>
 * 
 *         <p>
 *         <u> Exemple</u> dison que nous avons la classe ci-dessous si nous
 *         créeons une méthode accessible via un appel get sur cette url
 *         <b>/api/toto</b> et qui renvoie un objet de type Foo
 * 
 *         <pre>
 *         public class Foo {
 *         	private String a;
 *         	private String b;
 *         }
 * 
 *         </pre>
 * 
 *         <h3>Alors</h3> Dans la réponse nous aurons éa
 * 
 *         <b>
 * 
 *         <pre>
 *         	{"a":"valeur de a", "b" : "valeur de b"}
 *         </pre>
 * 
 *         </b>
 *         </p>
 * 
 */

@RestController
@RequestMapping("travel-agency/api")
public class ApiController {
	@Autowired
	private HotelDao dao;

	@RequestMapping(value = "/rechercher", produces = "application/json", method = RequestMethod.GET)
	public List<Hotel> rechercher(@RequestParam(name = "minPrix", required = false) String minPrix,
			@RequestParam(name = "maxPrix", required = false) String maxPrix,
			@RequestParam(name = "adresse", required = false) String adresse) {
		if (!tryParse(minPrix) && !tryParse(maxPrix)) {
			// erreur de validation les prix doivent étre des entiers positif
			throw new ValidationException("001", 400, "le prix min et prix max doivent être des entiers positifs");
		}

		if (minPrix == null && maxPrix == null && adresse == null) {
			return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
		}
		if (adresse == null) {
			return dao.listParPrix(maxPrix == null ? 99999 : Integer.parseInt(maxPrix),
					minPrix == null ? 0 : Integer.parseInt(minPrix));
		}

		return dao.listerToutFiltre(maxPrix == null ? 99999 : Integer.parseInt(maxPrix),
				minPrix == null ? 0 : Integer.parseInt(minPrix), adresse);
	}

	private boolean tryParse(String s) {
		if (s == null) {
			return true;
		}
		try {
			int i = Integer.parseInt(s);
			return i > 0;
		} catch (Exception e) {
			return false;
		}
	}
}
