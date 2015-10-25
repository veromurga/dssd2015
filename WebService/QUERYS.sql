INSERT INTO revista
            (id,
             nombre)
VALUES (60,
        'Gente');
        
        
SELECT
  `id`,
  `resumen`,
  `nombre_resumen`,
  `estado`,
  `id_revista`
FROM `garc`.`articulo`
LIMIT 0, 1000;
 


SELECT a.id AS id_articulo FROM articulo AS a WHERE a.nombre_resumen="nombre de oko"

SELECT
  `id`,
  `resumen`,
  `nombre_resumen`,
  `estado`,
  `id_revista`
FROM `garc`.`articulo`
LIMIT 0, 1000;


SELECT
  `id`,
  `id_revista`,
  `id_articulo`
FROM `garc`.`revista_articulo`
LIMIT 0, 1000;




INSERT INTO `garc`.`revista_articulo`
            (`id`,
             `id_revista`,
             `id_articulo`)
VALUES ('id',
        'id_revista',
        'id_articulo');
        
        
        
        SELECT
  `id`,
  `id_revista`,
  `id_articulo`
FROM `garc`.`revista_articulo`
LIMIT 0, 1000;
        
        
        


INSERT INTO `garc`.`articulo`
            (`id`,
             `resumen`,
             `nombre_resumen`,
             `estado`,
             `id_revista`)
VALUES ('id',
        'resumen',
        'nombre_resumen',
        'estado',
        'id_revista');
        
        
