https://dev.ehret.me/la-quete-du-graal.js/

Tout refaire tous les deux ans ?

Comparaison des frameworks.


1) Vanilla JS + jQuery

Pas morts !

 - ça fonctionne partout
 - plugins (mobile, qunit, etc)
 
jQuery toujours utile ?

ajax -> fetch
deferred -> promise
animate -> css3

jQuery n'est pas du javascript, et les développeurs ne connaissent plus javascript raw


2.) Backbone

pas mort !

Toujours léger pour communiquer avec un backend en mode REST.
Assez facile à apprendre

Orienté extensions : marionette, Giraffe, ...

Il est minimaliste, il faut ajouter beaucoup de plugins pour tester, etc... Un peu un défaut.


3.) ember

pas mort !

framework all in one
génération côté serveur

C'est un monstre ! inclus handlebars, convention over configuration.
Coût d'entrée important, mais ensuite très bonne productivité


SEO: avec fastboot, avec des limitations (pas de js executable pour reprendre le html côté client)

Très très actif ! (5 à 15 commits par jour)


4.) Angular 1

Pas mort !

Google all the things
All in one, two way data binding, c'était la grosse fonctionnalité
Injection de dépendances et tests : karma ngMock, etc
MVC ou MVVM => MVW
angular*: beaucoup d'extensions
les formulaires sont top

Courbe d'apprentissage longue
Performance pas top (gros projets), surveiller les watchers

SEO: prerender.io payant

Avenir ? on sait pas ? chacun sa vie ? 
Aujourd'hui on a la 1.5, et la 1.6 va arriver, migration Concepts 2.x => 1.x



5.) Angular 2.X

En gestation, pas mort !

Shadow dom
ES2015 modules
server side rendering
components
5x plus rapide qu'angular 1

SEO: universal angular 2

L'avenir ? on sait pas... devons-nous nous investir
Apprendre RxJs

Pas mobile first, 500KB, gros bébé


6.) REACT

Pas mort, non plus !

Orienté composants réutilisables
Isomorphic
Performances top
React native, android ios windows phone

Par contre: énormément de choses à connaitre... quasiment aussi énorme qu'angular à maitriser
Très gros!


7.) Web components

on choisit ce dont on a besoin.
c'est standard.

Limitations : on peut pas tout "polyfiller"

Premier abord difficile (tutos, docs)


8.) Polymer

Pas mort !

bon sucre
web component tester, vulcanize

catalogue des éléments

Mises à jour mineures un peu violentes
Bower...


9.) Vue.js

Pas mort !

Composants vue HTML / CSS / JS standards
Binding : it just works, pas de $apply ou autre
pas mal d'extensions vue-router, vuex, vue-loader


Par contre : dans l'ombre d'angular et de react. Un peu seul, mais très bien ! Une petite communauté
Fait par un Français : Evan You

=> pourquoi ne pas l'utiliser et contribuer ?


Conclusion : Comparison is the death of joy

Bien réfléchir au choix du framework.

Le grand gagnant : ember (pour le logo, pas pour le reste ;) )

Présence en conférence : AngularJs TRES présent. Ember aurelia backbone très peu représentés ?!?

issuestats.com : angular et jquery ont les mêmes courbes. Idem pour ember et React. Le bon elève c'est Vue.js: issue très vite fermée.

SEO par ci par là : coûteux

Pourquoi tous ces frameworks: parceque les géants veulent attirer les devs : on fait des trucs sexy pour attirer !

Communauté: beaucoup de fan boys, dur d'avoir un avis objectif !
Les communautés sont fatiguées de tous ces frameworks.
=> on peut faire des choses simples sans ces frameworks !

Ce n'est pas fini: aurelia, riot


Tous ces frameworks sont vivants, pas la peine de changer.
Fort ADN java : partir sur angular2 typesript ?

Choix: appli simple ? mobile ? compétences de l'équipe ?

https://frama.link/graaljs















