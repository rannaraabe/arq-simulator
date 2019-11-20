# arq-simulator
This program was made to simulate an actual system focusing on it's memmory management. It recieves the number of cores(only multiples of 2)
and creates the cache L1, L2 and the primary virtual memory...(TODO rewrite)


The base test in Main() creates a PC with 600 slots worth of data, 2 cpus and 4 cores. Its cache L2 has 10 times less space than its actual memory and its l1 cache has 2 times less than its l2.

for it to work the main memory must be a factor of 20!


# How it works

It tries to read or write a memory address, but for it to do that this address needs to be loaded in the core cache l1.

* OBS.: This program maintains data coherence in all of its caches, so if an address is loaded to the l1 cache it has to be loaded to the l2 cache of the given CPU.
* OBS.: Because this program maintains data coherence when we change a value in anywhere, be it in an l1, l2 or memory, it'll be updated in whenever this value is being used

# Authors

* Victor Ângelo Graça Morais - https://github.com/bllackangell
* Ranna Raabe Fernandes da Costa - https://github.com/rannaraabe