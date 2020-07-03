package com.gabi.pruebasjpa;

import com.gabi.model.Noticia;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCreate {

    public static void main(String[] args) {

        Noticia noticia = new Noticia();
        noticia.setTitulo("Proximo Estreno: Juego2");
        noticia.setDetalle("algo de texto2");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");
///PRUEBAS PARA REPOSITORIOS



//        PeliculaRepository repositoryPel = context.getBean("peliculaRepository", PeliculaRepository.class);
//
//        List<Pelicula> lista =  repositoryPel.findById(7);
//        for(Pelicula p : lista) {
//            System.out.println(p.getHorarios());
//        }



//        HorarioRepository horarioRepositoryObj = context.getBean("horarioRepository", HorarioRepository.class);
//
//        System.out.println(horarioRepositoryObj.findAll());


//        DetalleRepository detalleRepositoryObj = context.getBean("detalleRepository", DetalleRepository.class);
//
//        System.out.println(detalleRepositoryObj.findAll());



//        PeliculaRepository repositoryPel = context.getBean("peliculaRepository", PeliculaRepository.class);
//
//        List<Pelicula> li = repositoryPel.findAll();
//        System.out.println(li);



       // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        List<Noticia> not = null;
//        try {
//            not = repository.findByFechaBetween(format.parse("2020-01-02"), format.parse("2020-07-01"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(not);



        //PRUEBAS CRUD REPOSITORY

        // NoticiasRepository repository = context.getBean("noticiasRepository", NoticiasRepository.class);
//        Iterable<Noticia> iterador = repository.findAll();
//        for(Noticia n : iterador){
//            System.out.println("data:" + n.getTitulo());
//        }

//        List<Integer> li = new ArrayList<Integer>();
//        li.add(1);
//        li.add(2);
//
//        Iterable<Noticia> fd = repository.findAllById(li);


        context.close();
    }
}
