select * from Cinema
where MOD(id,2) and description != "boring"
order by rating desc