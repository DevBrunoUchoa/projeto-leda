import pandas as pd
import matplotlib.pyplot as plt

# Ler o arquivo CSV acumulativo
df = pd.read_csv("C:/Users/MateusH/Desktop/novo_priojeto_sem_erros/Projeto_EDA_LRU_FIFO/src/comparandoFifoLru/cache_metrics.csv")

# Exibir os dados
print(df)

# Plotar gráficos comparativos
plt.figure(figsize=(12, 8))

# Gráfico de Hit Rate ao longo das execuções
plt.subplot(2, 2, 1)
plt.plot(df['FIFO Hit Rate'], label='FIFO Hit Rate')
plt.plot(df['LRU Hit Rate'], label='LRU Hit Rate')
plt.xlabel('Execução')
plt.ylabel('Hit Rate')
plt.title('Hit Rate ao longo das execuções')
plt.legend()

# Gráfico de Miss Rate ao longo das execuções
plt.subplot(2, 2, 2)
plt.plot(df['FIFO Miss Rate'], label='FIFO Miss Rate')
plt.plot(df['LRU Miss Rate'], label='LRU Miss Rate')
plt.xlabel('Execução')
plt.ylabel('Miss Rate')
plt.title('Miss Rate ao longo das execuções')
plt.legend()

# Gráfico de Replacements ao longo das execuções
plt.subplot(2, 2, 3)
plt.plot(df['FIFO Replacements'], label='FIFO Replacements')
plt.plot(df['LRU Replacements'], label='LRU Replacements')
plt.xlabel('Execução')
plt.ylabel('Replacements')
plt.title('Replacements ao longo das execuções')
plt.legend()

# Gráfico de Average Access Time ao longo das execuções
plt.subplot(2, 2, 4)
plt.plot(df['FIFO Avg Access Time'], label='FIFO Avg Access Time')
plt.plot(df['LRU Avg Access Time'], label='LRU Avg Access Time')
plt.xlabel('Execução')
plt.ylabel('Average Access Time')
plt.title('Average Access Time ao longo das execuções')
plt.legend()

plt.tight_layout()
plt.show()