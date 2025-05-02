# Flwr for Federated Learning

[Flower (flwr)](https://flower.dev) is a flexible and extensible federated learning framework that simplifies the development and deployment of federated learning systems. By enabling collaboration across distributed data sources while preserving data privacy, Flower provides tools to build scalable and secure FL solutions. This integration brings the power of Flower into AIOpsLab.
This integration enables simulation, fault injection, and evaluation of federated learning (FL) scenarios within the AIOpsLab environment.

## Key Additions

- **Docker-based Flower Deployment**: Run Flower’s components — `SuperLink`, `ServerApp`, `SuperNode`, and `ClientApp` — in Docker containers to simulate local FL environments.
  
- **Federated Fault Injection**: Inject FL-specific faults including:
- **SuperNode termination** – Simulates communication breakdown between client and server.
- **Model misconfiguration** – Tests how agents handle faulty model setups during training.

- **LLaMa-3 Agent Integration**: Added support to evaluate the LLaMa-3 LLM on detection tasks involving Flower-based FL setups.

## Use Cases

This integration enables:

- Benchmarking of AI agents in federated environments.
- Simulation of realistic FL faults (e.g., dropped clients, corrupted models).
- Comparison of LLM-based agents (e.g., LLaMa-3) on fault detection performance.

## Future Work

Planned enhancements include:

- Kubernetes-based deployment of Flower.
- Multi-device federated training simulations.
- Broader fault coverage and support for newer LLM agents like GPT-4 and DeepSeek.

## Note on Kubernetes Folder

The `kubernetes` folder is included for storage purposes but is currently not in use.