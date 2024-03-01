
--------------------------------------------------------------------------
procedure inicializar (colonia: ref array(1..80) of boolean) is
--------------------------------------------------------------------------
    i: integer;
begin
    i := 1;
    while i <= elementos loop
        colonia(i) := (i mod 20) = 0;
        i := i + 1;
    end loop;
end;