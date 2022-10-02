In this project we downgrading from Redux to just React:
   - 01-redux-api: initial project is created by using Redux.
   - 02-context-api: in second project Redux is replaced by using useContext().
		useContext() is good for rarely/ocasionally changes (e.g. authentificatuion, theming),
		but for frequent changes (e.g. products) ir better to use hooks.
   - 03-custom-hooks-api: in third project project ir rewritten to fully use custom hooks (but, actually, they mimic Redux behavior).
   - 04-bonus-multiple-slices: in fourth projetct: 
		In previous project was shown how to manage one slice (i.e. one kind of) state with the custom store hook.
		You can also use it to manage multiple, independent state slices though.
		Project 04 is enhanced example where more than one state slice gets managed.
