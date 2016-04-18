select ROUTINE_NAME
from information_schema.ROUTINES
where ROUTINE_SCHEMA = 'souvenir' and ROUTINE_TYPE = 'PROCEDURE'
order by ROUTINE_NAME asc;