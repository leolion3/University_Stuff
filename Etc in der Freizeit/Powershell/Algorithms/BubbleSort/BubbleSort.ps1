# Bubble Sort
$array = 99...0
echo Unsorted: $array
function bubbleSort($array){
	for($i=0;$i -lt $array.length;$i++){
		for($a=0;$a -lt $array.length-1;$a++){
			if($array[$a] -gt $array[$a+1]){
				$first = $array[$a]
				$array[$a] = $array[$a+1]
				$array[$a+1] = $first
			}
		}
	}
}
bubbleSort $array
echo Sorted: $array
